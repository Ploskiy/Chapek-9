package by.ploskiy.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogController {

    private static List<String> log = new ArrayList<String>();

    public void addStringToLog(String event){
        log.add(event);
    }

    public void addListtoLog(List<String> eventsList){
        log.addAll(eventsList);
    }

    public List<String> getAllLogList() {
        while (log.size() > 10){
            log.remove(0);
        }

        return log;
    }
}
