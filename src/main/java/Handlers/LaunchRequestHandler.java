package Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;
import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler { //LaunchRequest occurs when the skill is invoked without a specific intent
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String speechText = "Welcome to the Bus Tracker Skill. Try saying, where is my bus?";
        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Bus Tracker", speechText)
                .withReprompt(speechText)
                .build();
    }
}
