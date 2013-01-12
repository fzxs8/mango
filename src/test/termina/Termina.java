package termina;

import org.eclipse.tm.internal.terminal.connector.TerminalConnector;
import org.eclipse.tm.internal.terminal.connector.TerminalConnector.Factory;

public class Termina {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Factory terminalConnectorFactory = null;
        TerminalConnector connector = new TerminalConnector(terminalConnectorFactory, "", "", false);
    }
}
