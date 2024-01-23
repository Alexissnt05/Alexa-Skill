package Handlers;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class BusTrackerStreamHandler extends SkillStreamHandler { //Entry point of lambda function

    private static Skill getSkill() {
        return Skills.standard().addRequestHandlers(new LaunchRequestHandler(),
                                                    new CheckScheduleIntentHandler()).build();
    }
    public BusTrackerStreamHandler() {
        super(getSkill());
    }
}

