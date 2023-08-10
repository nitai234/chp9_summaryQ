package com.example.chp9_summaryq;

import java.util.ArrayList;

public class Questions
{
    private int current = 0;
    private ArrayList <Question> questions;

    public Questions()
    {
        questions = new ArrayList<Question>();
        Question q1 = new Question("23 + 9", "34", "32", "45", "29", 2);
        Question q2 = new Question("123 * 34", "5008", "4632", "4182", "3965", 3);
        Question q3 = new Question("מהי העיר בירה של עירק", "בגדאד", "טהרן", "ארביל", "פריז", 1);
        Question q4 = new Question("מה פירוש המילה summry", "קיצי", "מסלול", "מחבט", "סיכום", 4);
        Question q5 = new Question("כמה ספרים ג.ק.רולינג הוציאה", "7", "10", "8", "11", 2);
        Question q6 = new Question("באיזה שנה הומצא הוויז", "2006", "2000", "2011", "2008", 1);
        Question q7 = new Question("1 / 0", "1", "0", "12356", "אין פתרון", 4);
        Question q8 = new Question("מי הכי מגניב בעולם", "נתאי ריינר", "לא ידוע", "אף אחד", "אני", 1);
        Question q9 = new Question("איפה נמצא הקוטב הצפוני", "בשמיים", "בדרום", "בצפון", "הוא לא קיים", 3);
        Question q10 = new Question("כמה שעות אריות ישנים ביום", "12", "20", "6", "16", 2);
        Question q11 = new Question("295 / 5", "59", "61", "53", "49", 1);
        Question q12 = new Question("כמה יבשות יש", "6", "7", "8", "9", 2);
        Question q13 = new Question("1+1", "2", "2", "4", "11",2);
        Question q14 = new Question("מהו האיבר המיותר בגוף", "מוח", "לבלב", "ציפורן של הזרת", "תוספתן", 4);
        Question q15 = new Question("כמה שאלות יש בשאלון הזה", "20", "16", "15", "30", 3);

        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
        questions.add(q6);
        questions.add(q7);
        questions.add(q8);
        questions.add(q9);
        questions.add(q10);
        questions.add(q11);
        questions.add(q12);
        questions.add(q13);
        questions.add(q14);
        questions.add(q15);
    }

    public void setCurrent(int current)
    {
        this.current = current;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public int getCurrent() {
        return current;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
