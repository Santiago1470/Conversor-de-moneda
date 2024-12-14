import java.util.List;
import java.util.Map;

public record ConversionApi(String result, String base_code, String target_code,
                            double conversion_rate, double conversion_result , int year,
                            int month, int day, Map<String, Double>conversion_rates,
                            Map<String, String> target_data, List<List<String>> supported_codes) {
}