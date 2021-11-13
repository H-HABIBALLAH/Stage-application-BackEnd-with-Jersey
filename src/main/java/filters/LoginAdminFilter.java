package filters;


import org.glassfish.jersey.internal.util.Base64;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;


@Provider
public class LoginAdminFilter implements ContainerRequestFilter {

    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
    String username = "";
    String password = "";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("called");
        if(containerRequestContext.getUriInfo().getPath().contains("offres/all")){
            List<String> authHeaders = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
            if (authHeaders.size() > 0) {
                String authToken = authHeaders.get(0);
                authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
                String decodedString = Base64.decodeAsString(authToken);
                StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");

                password = tokenizer.nextToken();
                username = tokenizer.nextToken();

                if (username.equals("Loic@ensibs.com") && password.equals("abcde"))
                    return;
            }
            Response unauthorizedSatuts = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("User cannot access the ressource")
                    .build();

            containerRequestContext.abortWith(unauthorizedSatuts);
        }
    }
}
