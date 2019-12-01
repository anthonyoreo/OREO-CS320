package sample;


public class questions {

    public questions()
    {
        ;
    }

    String[] questions = {
            "Click 'next' to start assessment",
            //Auditory Processing
            "Did you or a loved one have a hard time understanding and answering simple questions",
            "Did you have to repeat the questions or have the questions repeated to you?",
            "Did you note hesitation when answering the question?",
            "Did you or your loved on take more than 10 seconds to start answering the question?",
            //Problem Solving
            "Did you or your loved one have a hard time solving everyday problems?",
            "Did you or your loved one have a hard time knowing what to do if you or your loved one were sick?",
            "Did you or your loved on know what to do when an appliance breaks?",
            "Did you or your loved one know what to do in case of emergency?",
            //Reasoning
            "Did you or your loved one have a hard time understanding information?",
            "Did you or your loved one have a hard time understanding saying?",
            "Did you or your loved one have a hard time completing simple mathematical problems or balancing checkbooks?",
            //Memory
            "Did you or your loved one have a hard time remembering names of family members?",
            "Did you or your loved one have a hard time remembering dates that you or your loved one used to know?",
            "Did you or your loved one lose things frequently?",
            //Pragmatics
            "Did you or your loved one have a hard time maintaining topic during conversations?",
            "Did you or your loved one had a hard time maintaining eye contact?",
            "Were you or your loved one impulsive?",

            //Assessment

            //Auditory Processing
            "Is Florida a part of the United States?",
            "Are there 36 hours in a day?",
            "Have you had lunch yet?",
            "Is my name Lucy?",
            "Do dogs bark?",
            //Problem Solving
            "What would you do if you have a toothache?",
            "What would you do if your stove stopped working?",
            "What would you do if you forget to put the milk in the fridge?",
            "What would you do if you lock the keys in your car?",
            "What would you do if the newspaper did not get delivered?",
            //Memory
            "Please repeat the following numbers: 0, 4, 7, 9",
            "Please repeat the following sentence: it was a cloudy day yesterday",
            "Have you had any visitors today?",
            "What did you eat yesterday at lunch time?",
            //Reasoning
            "Please correct the following: two plus two is 5",
            "What does the following saying mean: an apple a day keeps the doctor away.",
            "What is thin, light, and can be used to wipe tears?",
            "What does the word friendly mean?",
            "Please fill in the following question: Child is to parent as kitten is to _________",
            //Pragmatics
            "Did clinician observed patient maintain eye contact?",
            "Was the patient able to stay on topic?",
            "Did patient initiate social exhanges?",
            "Did the patient wait for his/her turn to answer questions?",
            "Was the patient able to self-correct when giving wrong information?"
    };

    public String getQuestion(int question) {
        return questions[question];
    }

}