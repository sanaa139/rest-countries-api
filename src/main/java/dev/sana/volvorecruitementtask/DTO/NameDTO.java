package dev.sana.volvorecruitementtask.DTO;

public class NameDTO {
    private String common;
    private String official;

    public NameDTO(String common, String official) {
        this.common = common;
        this.official = official;
    }

    public NameDTO() {
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    @Override
    public String toString() {
        return "NameDTO{" +
                "common='" + common + '\'' +
                ", official='" + official + '\'' +
                '}';
    }
}
