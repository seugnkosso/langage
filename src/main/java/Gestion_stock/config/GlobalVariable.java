package Gestion_stock.config;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data // génère les getters et setters toString()...
@RequiredArgsConstructor // génère constructeur all final attribut
public class GlobalVariable {
    public static final String urlFront = "http://localhost:4200";
    public static final String size = "15";
}
