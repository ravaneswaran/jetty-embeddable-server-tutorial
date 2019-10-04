package demo.rc.jetty;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;


public class Main {
	private static final Logger logger = Logger.getLogger(Main.class.getName());

	private Server server;

	public void start() throws Exception {
		this.server = new Server();
		ServerConnector connector = new ServerConnector(this.server);
		connector.setPort(8080);
		this.server.setConnectors(new Connector[] { connector });

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		this.server.setHandler(context);

		this.server.start();
		this.server.join();
	}

	public static void main(String[] args) {
		Main application = new Main();
		try {
			application.start();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
