package chapter2.variablecapturing;

public class EmailSender {
    public static void main(String[] args) {
        //final variable
        final String banglaMsg = "বাংলাদেশ";
        //effectively final
        String englishMsg = "Bangladesh";

        MessageTranslator translator = (String msg) -> {
            return banglaMsg.equals(msg) ? englishMsg : "Unknown";
        };

        EmailSender emailSender = new EmailSender();
        emailSender.send(translator, "আমেরিকা");
    }

    public void send(MessageTranslator translator, String message) {
        String translated = translator.translate(message);
        System.out.println("Sending email with translated " + "message: " + translated);
    }
}
