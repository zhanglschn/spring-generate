package SimpleJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Author: chenssy
 * @Date: 2016/7/17 16:44
 */
public class SimpleJob implements Job{
    @Override
    public void execute(JobExecutionContext jobtx) throws JobExecutionException {
        System.out.println("trrigered.time is " + new Date());
    }
}
