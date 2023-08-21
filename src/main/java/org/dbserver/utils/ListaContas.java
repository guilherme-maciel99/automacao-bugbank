package org.dbserver.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListaContas {
    List<String> numeroContas = new ArrayList<>();

    public void adicionarNumeroConta(String texto){
        String regex = "\\b\\d{3}-\\d\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        if (matcher.find()) {
            numeroContas.add(matcher.group());
        }
    }
    public String getContaPorPosicao(int pos){
        return numeroContas.get(pos);
    }


}
