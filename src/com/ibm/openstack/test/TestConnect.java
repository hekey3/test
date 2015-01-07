package com.ibm.openstack.test;

import java.util.List;

import org.openstack4j.api.OSClient;
import org.openstack4j.model.image.Image;
import org.openstack4j.openstack.OSFactory;

public class TestConnect {

	public static void main(String[] args) {
		OSClient os = V2();
		List<? extends Image> images = os.images().list();
		for (Image image : images) {
			System.out.println("Image Name : "+ image.getName() + " , Status : " + image.getStatus());
			
		}
	}

	public static OSClient V2(){
		OSClient os = OSFactory.builder()
                .endpoint("http://9.112.233.26:5000/v2.0")
                .credentials("admin", "openstack1")
                .tenantName("service")
                .authenticate();
		return os;
	}
	
}
