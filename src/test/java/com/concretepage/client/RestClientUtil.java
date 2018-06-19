package com.concretepage.client;

import org.springframework.beans.factory.annotation.Autowired;

import es.hospital.dao.util.AlertasCorreo;

public class RestClientUtil {
       @Autowired
       AlertasCorreo correo;
       
       
       public void prueba() {
    	   correo.sendEmail("atfgWsuscribeteS!@gmail.com", "holii", "que tal");
       }
}
