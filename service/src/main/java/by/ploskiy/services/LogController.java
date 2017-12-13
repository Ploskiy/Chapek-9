package by.ploskiy.services;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class LogController {

    private static List<String> log = new LinkedList<String>();

    public synchronized void addStringToLog(String event){
        log.add(event);
    }

    public synchronized void addListToLog(List<String> eventsList){
        log.addAll(eventsList);
    }

    public synchronized List<String> getAllLogList() {
        while (log.size() > 10){
            log.remove(0);
        }

        return log;
    }
}
