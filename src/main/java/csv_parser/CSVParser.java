package csv_parser;

import contract.CellularContract;
import contract.ContractType;
import contract.InternetContract;
import contract.TelevisionContract;
import person.Gender;
import person.Person;
import repository.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class CSVParser {
    private static final String SEMICOLON = ";";
    private static final String COMMA = ",";

    public void parseCSV(Repository repository, String fileName) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(SEMICOLON);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (List<String> record : records) {
            ContractType type = ContractType.valueOf(record.get(10).toUpperCase());
            switch (type) {
                case CELLULAR:
                    repository.add(createCellularContract(record));
                    break;
                case INTERNET:
                    repository.add(createInternetContract(record));
                    break;
                case TELEVISION:
                    repository.add(createTelevisionContract(record));
                    break;
                default:
                    throw new IllegalArgumentException(record.get(10) + " is not a contract type");
            }
        }
    }

    private CellularContract createCellularContract(List<String> record) {
        Integer[] extraInfo = parseExtraInfo(record.get(11));
        return new CellularContract(
                Integer.parseInt(record.get(0)),
                LocalDate.parse(record.get(1)),
                LocalDate.parse(record.get(2)),
                Long.parseLong(record.get(3)),
                getPerson(record),
                extraInfo[0],
                extraInfo[1],
                extraInfo[2]
        );
    }

    private Integer[] parseExtraInfo(String info) {
        String[] values = info.split(COMMA);
        List<Integer> intValues = new LinkedList<>();
        for (String value : values) {
            intValues.add(Integer.parseInt(value));
        }
        return intValues.toArray(new Integer[0]);
    }

    private InternetContract createInternetContract(List<String> record) {
        return new InternetContract(
                Integer.parseInt(record.get(0)),
                LocalDate.parse(record.get(1)),
                LocalDate.parse(record.get(2)),
                Long.parseLong(record.get(3)),
                getPerson(record),
                parseExtraInfo(record.get(11))[0]
        );
    }

    private TelevisionContract createTelevisionContract(List<String> record) {
        return new TelevisionContract(
                Integer.parseInt(record.get(0)),
                LocalDate.parse(record.get(1)),
                LocalDate.parse(record.get(2)),
                Long.parseLong(record.get(3)),
                getPerson(record),
                parseExtraInfo(record.get(11))[0]
        );
    }

    private Person getPerson(List<String> record) {
        return new Person.Builder()
                .setId(Integer.parseInt(record.get(4)))
                .setFullName(record.get(5))
                .setBirthday(LocalDate.parse(record.get(6)))
                .setGender(Gender.valueOf(record.get(7).toUpperCase()))
                .setPassportSeries(Integer.parseInt(record.get(8))).setPassportId(Integer.parseInt(record.get(9)))
                .build();
    }

}
