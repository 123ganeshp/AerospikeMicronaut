package com.restapi.auth;


import com.restapi.Util.CasbinEnforcerUtil;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.AbstractSecurityRule;
import io.micronaut.security.rules.SecuredAnnotationRule;
import io.micronaut.security.rules.SecurityRuleResult;
import io.micronaut.security.token.RolesFinder;
import io.micronaut.web.router.RouteMatch;
import jakarta.inject.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.casbin.jcasbin.main.Enforcer;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
@Singleton
public class CasbinSecurity extends AbstractSecurityRule {
    public static final Integer ORDER;
    private static final Logger LOGGER;
    private final Enforcer enforcer;
    public CasbinSecurity(RolesFinder rolesFinder) {
        super(rolesFinder);
        this.enforcer = CasbinEnforcerUtil.getCasbinEnForcer();
    }

    @Override
    public Publisher<SecurityRuleResult> check(HttpRequest<?> request, RouteMatch<?> routeMatch, Authentication authentication) {
        if (authentication == null) {
            if (LOGGER.isInfoEnabled())
                LOGGER.info("Fall back to Micronaut security as authentication is null");
            return Mono.just(SecurityRuleResult.UNKNOWN);
        } else if (enforcer != null && enforcer.enforce(authentication.getName(), request.getPath(), request.getMethod().name())) {
            if (LOGGER.isInfoEnabled())
                LOGGER.info("Casbin Authorization successful for path : " + request.getPath());
            return Mono.just(SecurityRuleResult.ALLOWED);
        }
        if (LOGGER.isInfoEnabled())
            LOGGER.info("Casbin Authorization failed for path : " + request.getPath());
        return Mono.just(SecurityRuleResult.REJECTED);
    }


    public int getOrder() {return ORDER;}static {ORDER = SecuredAnnotationRule.ORDER - 100;
        LOGGER = LogManager.getLogger(CasbinSecurity.class);
    }
}


