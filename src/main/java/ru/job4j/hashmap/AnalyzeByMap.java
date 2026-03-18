package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        int totalCount = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalCount++;
            }
        }
        return totalCount > 0 ? totalScore / totalCount : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            double average = pupil.subjects().size() > 0 ? sum / pupil.subjects().size() : 0;
            result.add(new Label(pupil.name(), average));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.put(subject.name(),
                        subjectScores.getOrDefault(subject.name(), 0) + subject.score());
            }
        }

        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            double average = (double) entry.getValue() / pupils.size();
            result.add(new Label(entry.getKey(), average));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> studentTotals = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            studentTotals.add(new Label(pupil.name(), sum));
        }
        studentTotals.sort(Comparator.naturalOrder());
        return studentTotals.isEmpty() ? null : studentTotals.get(studentTotals.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.put(subject.name(),
                        subjectScores.getOrDefault(subject.name(), 0) + subject.score());
            }
        }

        List<Label> subjectTotals = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            subjectTotals.add(new Label(entry.getKey(), (double) entry.getValue()));
        }
        subjectTotals.sort(Comparator.naturalOrder());
        return subjectTotals.isEmpty() ? null : subjectTotals.get(subjectTotals.size() - 1);
    }
}