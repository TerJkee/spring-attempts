import Beans.Client;
import logger.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  private Client client;
  private EventLogger eventLogger;

  App(Client client, EventLogger eventLogger) {
    this.client = client;
    this.eventLogger = eventLogger;
  }

  private void logEvent(String msg) {
    String message = msg.replaceAll(client.getId().toString(), client.getFullName());
    eventLogger.logEvent(message);
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    //Both works
        App app = (App) ctx.getBean("app");
    App app1 = ctx.getBean(App.class);

        app.logEvent("Hello 2");
    app1.logEvent("Hello 1");
  }


}
