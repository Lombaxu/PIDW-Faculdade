import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080); // Porta 8080
        
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(LoginServlet.class, "/login"); // Rota para login
        handler.addServlet(CadastroServlet.class, "/cadastro"); // Rota para cadastro
        
        server.setHandler(handler);
        server.start();
        server.join();
    }
}