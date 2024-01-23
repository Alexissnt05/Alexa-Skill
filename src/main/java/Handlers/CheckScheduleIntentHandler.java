package Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;
import com.amazon.ask.response.ResponseBuilder;
import org.alexis.BusArrivalInfo;

import java.util.Optional;

public class CheckScheduleIntentHandler implements RequestHandler { //RequestHandler handles an incoming request.
    @Override
    public boolean canHandle(HandlerInput handlerInput) { //returns a boolean, whether the request can be handled or not
        return handlerInput.matches(Predicates.intentName("CheckScheduleIntent").or(Predicates.intentName("ChequearHorarioDeAutobus")));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) { //handle method is executed after canHandle returns true
        BusArrivalInfo busArrivalInfo = new BusArrivalInfo();
        String speechText = "Your bus " + busArrivalInfo.getBusName() + " is arriving in " + busArrivalInfo.getDepartureTime() + "minutes";
        String respuesta = "tu autobús " + busArrivalInfo.getBusName() + "llega en " + busArrivalInfo.getDepartureTime() + "minutos";
        ResponseBuilder englishResponse = new ResponseBuilder().withSpeech(speechText).withShouldEndSession(true);
        ResponseBuilder spanishResponse = new ResponseBuilder().withSpeech(respuesta).withShouldEndSession(true);
        return handlerInput.matches(Predicates.intentName("CheckScheduleIntent")) ? englishResponse.build() : spanishResponse.build();
    }
}
