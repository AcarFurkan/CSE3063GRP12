package features.student.transcript;

import core.models.concretes.Transcript;

public class TranscriptView {
    TranscriptController transcriptController;
    public void showTranscript(Transcript transcript) {
        transcriptController = new TranscriptController();
    }

    public void showQuitMessage() {
        System.out.print("Press q to return Main Menu: ");
    }
}
