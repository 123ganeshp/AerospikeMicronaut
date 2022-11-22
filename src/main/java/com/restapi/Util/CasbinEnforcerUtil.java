package com.restapi.Util;

import org.apache.commons.io.IOUtils;
import org.casbin.jcasbin.main.Enforcer;
import org.casbin.jcasbin.model.Model;
import org.casbin.jcasbin.persist.file_adapter.FileAdapter;

import java.nio.charset.Charset;


//package com.restapi.casbinutil;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.casbin.jcasbin.main.Enforcer;
import org.casbin.jcasbin.model.Model;
import org.casbin.jcasbin.persist.file_adapter.FileAdapter;
//import org.slf4j.Logger;

import java.nio.charset.Charset;


public class CasbinEnforcerUtil {
        private static volatile Enforcer ENFORCER;
        private CasbinEnforcerUtil() {
        }
        private static Logger LOGGER = LogManager.getLogger(CasbinEnforcerUtil.class.getName());
        public static Enforcer getCasbinEnForcer() {
            if (ENFORCER == null) {
                synchronized (CasbinEnforcerUtil.class) {
                    if (ENFORCER == null) {
                        try {
                            Model model = new Model();
                            model.loadModelFromText(IOUtils.toString(ClassLoader.getSystemResource("casbin/model.conf"), Charset.defaultCharset()));
                            FileAdapter fileAdapter = new FileAdapter(ClassLoader.getSystemResourceAsStream("casbin/policy.csv"));
                            ENFORCER = new Enforcer(model, fileAdapter);
                        } catch (Exception e) {
                            if (LOGGER.isErrorEnabled())
                                LOGGER.error("Enforcer creation failed : " + e.getMessage());
                        }
                    }
                }
            }
            return ENFORCER;
        }
    }



