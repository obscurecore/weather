package com.hackerrank.weather.dto.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.stream.Collectors;

@Data
public class SearchableForm {

    private String query;

    @Nullable
    @JsonIgnore
    public String getFormattedQuery() {
        return formatQuery(query);
    }

    @Nullable
    @JsonIgnore
    private static String formatQuery(final String query) {
        if (StringUtils.isBlank(query)) {
            return null;
        }

        String formattedQuery = query.toLowerCase().trim();
        formattedQuery = StringUtils.appendIfMissing(formattedQuery, "%");
        formattedQuery = StringUtils.prependIfMissing(formattedQuery, "%");

        return formattedQuery;
    }

    @JsonIgnore
    public static String formatSearchQuery(@NonNull final String query) {
        String formattedQuery = query.toLowerCase()
                .trim()
                .replaceAll("\\s+", " ");
        formattedQuery = StringUtils.appendIfMissing(formattedQuery, "%");
        formattedQuery = StringUtils.prependIfMissing(formattedQuery, "%");

        return formattedQuery;
    }

    @Nullable
    @JsonIgnore
    public String getFtsQuery() {
        if (StringUtils.isBlank(query)) {
            return null;
        }
        return Arrays.stream(
                        query
                                .replace(":", "\\:")
                                .replace("|", "\\|")
                                .replace("*", "\\*")
                                .replace("!", "\\!")
                                .replace("?", "\\?")
                                .split("\\s+")
                )
                .map(q -> q + ":*")
                .collect(Collectors.joining(" | "));
    }
}
