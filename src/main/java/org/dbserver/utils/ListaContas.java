package org.dbserver.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListaContas {
    String numeroConta;

    public void adicionarNumeroConta(String texto){
        String regex = "\\b\\d{3}-\\d\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        if (matcher.find()) {
            this.numeroConta = matcher.group();
        }
    }
    public String getContaPorPosicao(){
        return this.numeroConta;
    }


}
