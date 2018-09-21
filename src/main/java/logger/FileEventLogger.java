package logger;

import Beans.Event;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class FileEventLogger implements EventLogger {

  private final Event event;
  private File file;
  private String filename;

  public FileEventLogger(Event event, String filename) {
    this.event = event;
    this.filename = filename;
  }

  public void init() throws IOException {
    this.file = new File(filename);
    //need to check file write access
    if (file.canWrite()) {
      logEvent(event);
    }

  }

  public void logEvent(Event event) throws IOException {
    FileUtils.writeStringToFile(file, event.toString(), true);
  }
}
