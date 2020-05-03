import org.netbeans.jemmy.*;
import org.netbeans.jemmy.explorer.*;
import org.netbeans.jemmy.operators.*;

public class ActionsSample implements Scenario {
    public int runIt(Object param) {
	try {
	    new ClassReference("org.netbeans.jemmy.explorer.GUIBrowser").startApplication();
	    JFrameOperator mainFrame = new JFrameOperator("GUI Browser");

            new JButtonOperator(mainFrame, "Reload after").push();

	    JTextFieldOperator testField = new JTextFieldOperator(mainFrame);

	    //type new value in the text field
	    testField.clearText();
	    testField.typeText("3");

	    JTextAreaOperator testArea = new JTextAreaOperator(mainFrame);

	    //select text in the text area
	    testArea.selectText("toString");

	    //puch button
	    new JButtonOperator(mainFrame, "Reload").push();

	    //wait "Reloaded" footer
	    new JLabelOperator(mainFrame, "Reloaded");

	} catch(Exception e) {
	    e.printStackTrace();
	    return(1);
	}
	return(0);
    }
    public static void main(String[] argv) {
	String[] params = {"ActionsSample"};
	org.netbeans.jemmy.Test.main(params);
    }
}