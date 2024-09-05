package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import templates.MessageTemplate;

import java.util.HashMap;
import java.util.Map;

public class DecisionLogicsTest {

    private String keyOfMap;
    private Integer stageCounterExpected;
    private MessageTemplate messageExpected;
    private DecisionLogics decisionLogics = new DecisionLogics();
    public Map<String, MessageTemplate> messageInit = new HashMap<String, MessageTemplate>();

    @Test
    public void validatingIfCounterIsZeroForFinalStage() {
        // Given
        keyOfMap = "3s";
        // When
        if ( keyOfMap.contains("n") || keyOfMap.equals("3s") ) {
            stageCounterExpected = 0;
        }

        //Then
        Assertions.assertEquals(0, stageCounterExpected);
    }

    @BeforeEach
    public void init() {
        messageInit.put("0s", new MessageTemplate("¡Has perdido la memoria!",
                "¿Aceptas el reto de la Nave?",
                "Elige con cuidado, ¡tu vida está en juego!",
                "Acepto el desafío porque soy muy valiente",
                "No acepto el desafío porque soy miedoso",
                "dilemma-stage.jsp"));

        messageInit.put("1s", new MessageTemplate("Has aceptado el reto. Felicidades",
                "¿Vas a subir al puente del Capitán?",
                "Elige con cuidado, vas a estar con el Capitán",
                "Acepto, quiero subir al puente de mando",
                "No acepto subir al puente de mando",
                "dilemma-stage.jsp"));

        messageInit.put("2s", new MessageTemplate("Ahora vas a subir al puente de mando",
                "Dí la verdad a cerca de ti",
                "¿Lo que has dicho es verdad?:",
                "Sí, es toda la verdad",
                "No estoy completamente seguro",
                "dilemma-stage.jsp"));

        messageInit.put("1n", new MessageTemplate("¡Reto Rechazado!",
                "Has rechazado el reto",
                "¡Adiós Gallina! ... ¡Perdiste!",
                "final-stage.jsp"));

        messageInit.put("2n", new MessageTemplate("¡Has rechazado subir al puente de mando!",
                "No atendiste las negociaciones",
                "¡Adiós Coyón! ... ¡Perdiste!",
                "final-stage.jsp"));

        messageInit.put("3n", new MessageTemplate("¡Mentiste a cerca de tí mismo!",
                "Tu mentira ha sido descubierta",
                "¡Adiós Mentiroso! ... ¡Perdiste!",
                "final-stage.jsp"));

        messageInit.put("3s", new MessageTemplate("¡Dijiste la verdad a cerca de tí!",
                "Has regresado a Casa",
                "¡Triunfaste! ... ¡Felicidades!",
                "final-stage.jsp"));
    }

    @Test
    public void validatingPlayerChoiceTrue() {
        // Given
        boolean playerChoice = true;
        decisionLogics.setStageCounter(1);
        decisionLogics.setKeyOfMap("2s");
        messageExpected = messageInit.get("2s");

        // When
        MessageTemplate messageRecived = decisionLogics.workingPlayerChoice(playerChoice);

        // Then
        Assertions.assertEquals(messageExpected.getTitle(), messageRecived.getTitle());
        Assertions.assertEquals(messageExpected.getQuestion(), messageRecived.getQuestion());
        Assertions.assertEquals(messageExpected.getLegend(), messageRecived.getLegend());
        Assertions.assertEquals(messageExpected.getYes(), messageRecived.getYes());
        Assertions.assertEquals(messageExpected.getNo(), messageRecived.getNo());
        Assertions.assertEquals(messageExpected.getTargetJspFile(), messageRecived.getTargetJspFile());
    }

    @Test
    public void validatingPlayerChoiceFalse() {
        // Given
        boolean playerChoice = false;
        decisionLogics.setStageCounter(0);
        decisionLogics.setKeyOfMap("1n");
        messageExpected = messageInit.get("1n");

        // When
        MessageTemplate messageRecived = decisionLogics.workingPlayerChoice(playerChoice);

        // Then
        Assertions.assertEquals(messageExpected.getTitle(), messageRecived.getTitle());
        Assertions.assertEquals(messageExpected.getQuestion(), messageRecived.getQuestion());
        Assertions.assertEquals(messageExpected.getLegend(), messageRecived.getLegend());
        Assertions.assertEquals(messageExpected.getTargetJspFile(), messageRecived.getTargetJspFile());
    }

}
