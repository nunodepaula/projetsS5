package fr.ensma.a3.ia.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


@Provider
public class AccessControlResponseFilter implements ContainerResponseFilter {
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        containerResponseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Headers", "Content-Type");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
        containerResponseContext.getHeaders().add("Access-Control-Max-Age", "20");  // en seconde
    }
}

