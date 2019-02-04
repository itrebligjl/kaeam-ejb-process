package com.eamtk.embedded.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.EJB;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.*;
import javax.ejb.Local;

import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.services.api.model.DeploymentUnit;
import org.jbpm.services.ejb.api.DeploymentServiceEJBLocal;


@Singleton
@Startup
public class StartupBean {

    public static final String DEPLOYMENT_ID = "com.eamtk:kaeam-ejb-process:0.0.1-SNAPSHOT";

	@EJB
	DeploymentServiceEJBLocal deploymentService;

    @PostConstruct
    public void init() {
    	//String[] gav = DEPLOYMENT_ID.split(":");

    	// Deploy the kjar here
    	String[] gav = DEPLOYMENT_ID.split(":"); // Splits into group, artifact, and version 
		DeploymentUnit deploymentUnit = new KModuleDeploymentUnit(gav[0], gav[1], gav[2]);
		deploymentService.deploy(deploymentUnit);
    }

}
