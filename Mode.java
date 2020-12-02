/**
 * OVERVIEW: questa classe rappresenta le possibili modalita' di accesso alla memoria:
 *           diretto, per valore e indiretto
 */
public enum Mode {
    /** Indirizzamento diretto */
    POSITION(0),
    /** Indirizzamento per valore */
    IMMEDIATE(1),
    /** Indirizzamento indiretto
     * Utilizza il RelativeBasePointer */
    RELATIVE(2);

    /** codice decimale */
    public final int code;

    /**
     * Post-condizioni: istanzia la modalita' di accesso
     * @param code codice
     */
    private Mode(int code){
        this.code = code;
    }

    /**
     * Post-condizioni: restituisce la modalita' di accesso ricavata dal codice ottenuto in input
     * @param code codice
     * @return la modalita' di accesso
     */
    public static Mode fromCode(int code) {
        for(Mode m: values()) if (m.code == code) return m;
        throw new IllegalArgumentException(("Invalid Mode: " + code));
    }
}
