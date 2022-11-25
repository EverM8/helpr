package org.soulcodeacademy.helpr.domanin.dto;

public class TokenDTO {
    private String acessToken;
    private String tokenType = "Bearer";

    public TokenDTO(String acessToken){
        this.acessToken = acessToken;
    }

    public String getAcessToken() {
        return acessToken;
    }

    public void setAcessToken(String acessToken) {
        this.acessToken = acessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
