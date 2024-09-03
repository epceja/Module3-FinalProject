package model;

import templates.MessageTemplate;

import java.util.HashMap;
import java.util.Map;

public class DecisionLogics {

    private int stageCounter;
    private String keyOfMap = "0n";
    private Map<String, MessageTemplate> message = new HashMap<String, MessageTemplate>();

    public DecisionLogics() {
    }

    public DecisionLogics(int stageCounter) {
        this.stageCounter = stageCounter;
    }

    public int getStageCounter() {
        return stageCounter;
    }

    public MessageTemplate workingPlayerChoice(boolean playerChoice) {
        // Initializing decision map if is empty
        if ( message.isEmpty() ) {
            message.put("0s", new MessageTemplate("¡Has perdido la memoria!",
                    "¿Aceptas el reto de la Nave?",
                    "Elige con cuidado, ¡tu vida está en juego!",
                    "Acepto el desafío porque soy muy valiente",
                    "No acepto el desafío porque soy miedoso",
                    "dilemma-stage.jsp"));

            message.put("1s", new MessageTemplate("Has aceptado el reto. Felicidades",
                    "¿Vas a subir al puente del Capitán?",
                    "Elige con cuidado, vas a estar con el Capitán",
                    "Acepto, quiero subir al puente de mando",
                    "No acepto subir al puente de mando",
                    "dilemma-stage.jsp"));

            message.put("2s", new MessageTemplate("Ahora vas a subir al puente de mando",
                    "Dí la verdad a cerca de ti",
                    "¿Lo que has dicho es verdad?:",
                    "Sí, es toda la verdad",
                    "No estoy completamente seguro",
                    "dilemma-stage.jsp"));

            message.put("1n", new MessageTemplate("¡Reto Rechazado!",
                    "Has rechazado el reto",
                    "¡Adiós Gallina! ... ¡Perdiste!",
                    "final-stage.jsp"));

            message.put("2n", new MessageTemplate("¡Has rechazado subir al puente de mando!",
                    "No atendiste las negociaciones",
                    "¡Adiós Coyón! ... ¡Perdiste!",
                    "final-stage.jsp"));

            message.put("3n", new MessageTemplate("¡Mentiste a cerca de tí mismo!",
                    "Tu mentira ha sido descubierta",
                    "¡Adiós Mentiroso! ... ¡Perdiste!",
                    "final-stage.jsp"));

            message.put("3s", new MessageTemplate("¡Dijiste la verdad a cerca de tí!",
                    "Has regresado a Casa",
                    "¡Triunfaste! ... ¡Felicidades!",
                    "final-stage.jsp"));
        }

        // Validating if it reached final stage to reset counter
        if ( keyOfMap.contains("n") || keyOfMap.equals("3s") ) {
            stageCounter = 0;
        }
        // Counter increment
        stageCounter ++;

        if (playerChoice) {
            keyOfMap = Integer.toString(stageCounter)+"s";
            return message.get(keyOfMap);
        }
        if ( !playerChoice ) {
            keyOfMap = Integer.toString(stageCounter)+"n";
            return message.get(keyOfMap);
        }
        return null;
    }
}
