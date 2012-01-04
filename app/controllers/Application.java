package controllers;

import play.data.validation.Required;
import play.data.validation.Valid;
import play.jobs.Job;
import play.mvc.Controller;

public class Application extends Controller {

    public static void  index(@Valid @Required String name) throws InterruptedException {

        int x = (Integer)await(new Job(){
            @Override
            public Integer doJobWithResult() throws Exception {
                Thread.sleep(2000);
                return 5;
            }
        }.now());

        render(x);
    }

    public static void hi(){
        render();
    }

}

