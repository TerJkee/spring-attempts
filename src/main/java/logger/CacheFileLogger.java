package logger;

import Beans.Event;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;

public class CacheFileLogger extends FileEventLogger {

  private int cachesize;
  private List<Event> cache;
  private File file;

  public CacheFileLogger(Event event, String filename, int cachesize) {
    super(event, filename);
    this.file = new File(filename);
    this.cachesize = cachesize;
  }

  public void logEvent(Event event) throws IOException {
    cache.add(event);

    if (cache.size() == cachesize) {
      writeEventsFromCache();
      cache.clear();
    }
  }

  private void writeEventsFromCache() throws IOException {
    List<String> results = cache.stream()
        .map(Event::toString)
        .collect(Collectors.toList());
    for (String result : results) {
      FileUtils.writeStringToFile(file, result);
    }
  }

  public void destroy(){

  }
}

