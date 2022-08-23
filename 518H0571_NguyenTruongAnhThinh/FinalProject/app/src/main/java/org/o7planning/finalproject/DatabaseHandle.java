package org.o7planning.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseHandle extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Final_project";
    private  static final String TABLE_NAME = "User_info";
    private static  final String TABLE_NAME1 = "Private_info";
    private static  final String TABLE_NAME2 = "Ques_info";
    private static  final String TABLE_NAME3 = "User_score";

    DatabaseHandle(Context context){
        super(context, DATABASE_NAME, null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(username TEXT PRIMARY KEY, password TEXT)");
        sqLiteDatabase.execSQL("create table " + TABLE_NAME1 + "(username TEXT PRIMARY KEY, name TEXT, age INT, sex TEXT)");
        sqLiteDatabase.execSQL("create table " + TABLE_NAME2 + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ques TEXT, an1 TEXT, an2 TEXT, an3 TEXT, an4 TEXT, tran TEXT, type TEXT)");
        sqLiteDatabase.execSQL("create table " + TABLE_NAME3 + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, user TEXT, score INTEGER, type TEXT, date DATETIME DEFAULT CURRENT_TIMESTAMP)");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'The charity aims to__food and shelter for underprivileged in the remote areas of the country', 'present', 'assist', 'provide', 'offer', 'provide', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'At school, children learn a lot of__such as maths, biology, history and English', 'subjects', 'topics', 'lessons', 'objects', 'subjects', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'The child that we caught__was made to stand in the corner of the class room.', 'misbehavior', 'misbehave', 'behaving', 'misbehaving', 'misbehaving', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'Make sure you__up the data on your computer, because you might get a virus.', 'back', 'store', 'save', 'copy', 'back', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'My parent will have celebrated 30 years of__by next week.', 'marry', 'married', 'marriageable', 'marriage', 'marriage', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'The singer was__on the piano by her sister', 'discarded', 'accompanied', 'performed', 'played', 'performed', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'He did not share his secrets with other people, but he__in her.', 'confessed', 'concealed', 'confided', 'consented', 'confided', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'Great__should be given to the conservation of endangered species', 'diversity', 'priority', 'opportunity', 'condition', 'priority', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'She__her success to hard work', 'described', 'devoted', 'blanned', 'ascribed', 'devoted', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'It is funny you should say that.I have just had the__thought.', 'like', 'indentical', 'alike', 'similar', 'similar', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'I have got lots of__but only few really good friends.', 'accuaintances', 'neighbors', 'best mates', 'partners', 'accpuaintances', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'Many plant and animal species are now on the__of extinction.', 'margin', 'verge', 'danger', 'horder', 'verge', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'People have used coal and oil to__electricity for a long time', 'bred', 'raise', 'cultivate', 'generate', 'generate', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'Water is__of two elements hydrogen and oxygen.', 'consisted', 'composed', 'making', 'comprising', 'composed', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'I want to__a table at the Bamboo Restaurant', 'maintain', 'manage', 'reserve', 'allow', 'reserve', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, '__candidates are likely to suceed in job interviews.', 'nervous', 'self_confident', 'self_conscious', 'self-doubt', 'self-confident', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'There are several places where residents face the threat of__every day.', 'terrorist', 'terrorism', 'terrorize', 'terror', 'terrorism', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'They are always__of what their children do.', 'support', 'supporting', 'supportive', 'supportively', 'supportive', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'The manager__his tember with the employees and shoured at them', 'had', 'lost', 'took', 'kept', 'lost', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'They were among the first companies to exploit the__of the Internet', 'potential', 'prospect', 'possibility', 'ability', 'potential', 'hd');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'If i were in charge, I__thing differently.', 'will do', 'would do', 'would done', 'had done', 'would do', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'Australia is big, but Canada is__Australia.', 'big', 'biggest', 'bigger than', 'than bigger', 'bigger than', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'David is 185 cm tall. He is__Andrew.', 'taller than', 'tall', 'taller', 'talled', 'taller than', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'I think that summer is__than winter', 'good', 'better', 'the best', 'better than', 'better', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'Do you think math and science__ more difficult than history and English?', 'is', 'was', 'a', 'are', 'are', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'In my opinion, this pink dress is__that green dress.', 'prettyer than', 'prettier than', 'more prettier', 'most prettier', 'prettier than', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'This summer was much__last summer', 'hotter than', 'the hottest', 'hoter than', 'most hotter', 'hotter than', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'It was not until she had arrived home__remembered her appointment with the docter.', 'that she', 'and she', 'she', 'when she', 'that she', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'When i last saw Jane, she__to find a job.', 'was trying', 'tried', 'are trying', 'is trying', 'was trying', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'He is going to get married__the end of this month', 'on', 'in', 'to', 'at', 'at', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'Increasing__of fruit in the diet may help to reduce the risk of heart disease.', 'the amount', 'an amount', 'the number', 'a number', 'the amount', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'I am afraid i am not really__to comment on this matter.', 'qualifying', 'qualified', 'quality', 'qualitative', 'qualified', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'If you are not Japanese, so that__are you?', 'nationalized', 'nation', 'nationality', 'national', 'nationality', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'The manager had his secredtary__the report for him.', 'typing', 'typed', 'type', 'to type', 'type', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, '__entering the hall, he found everyone waiting for him', 'With', 'On', 'At', 'During', 'On', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'The room needs__for the wedding.', 'decorating', 'to decorate', 'decorate', 'be decorate', 'decorating', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'I am considering__my job. Can you recommend a good company?', 'to move', 'moving', 'to change', 'changing', 'changing', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'The students__to be at school at 3p.m.', 'told', 'have told', 'were told', 'tell', 'were told', 'dg');");
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME2 + " values(null, 'He arrived late,__was annoying.', 'it', 'that', 'what', 'which', 'which', 'dg');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(sqLiteDatabase);
    }

    public boolean addUser(String text1, String text2){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", text1);
        contentValues.put("password", text2);
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public boolean addScore(String text1, Integer text2, String text3){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", text1);
        contentValues.put("score", text2);
        contentValues.put("type", text3);
        sqLiteDatabase.insert(TABLE_NAME3, null, contentValues);
        return true;
    }

    public boolean addInfo(String text1, String text2, int text3, String text4){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", text1);
        contentValues.put("name", text2);
        contentValues.put("age", text3);
        contentValues.put("sex", text4);
        sqLiteDatabase.insert(TABLE_NAME1, null, contentValues);
        return true;
    }

    public ArrayList getAllText(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<String>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            arrayList.add(cursor.getString(cursor.getColumnIndex("username")));
            cursor.moveToNext();
        }
        return arrayList;
    }
    public boolean Login(String username, String password)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor mCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE username=? AND password=?", new String[]{username,password});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }


    public ArrayList<QuestList> getAllQues() {
        ArrayList<QuestList> queslist = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from Ques_info where type='hd' ORDER BY RANDOM() LIMIT 8",null);

        while(res.moveToNext()) {
            String ques = res.getString(1);
            String an1 = res.getString(2);
            String an2 = res.getString(3);
            String an3 = res.getString(4);
            String an4 = res.getString(5);
            String tran = res.getString(6);

            QuestList newuser = new QuestList(ques, an1, an2, an3, an4, tran);
            queslist.add(newuser);
        }
        return queslist;
    }

    public ArrayList<QuestList> getAllQues1() {
        ArrayList<QuestList> queslist1 = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from Ques_info where type='dg'  ORDER BY RANDOM() LIMIT 8",null);

        while(res.moveToNext()) {
            String ques = res.getString(1);
            String an1 = res.getString(2);
            String an2 = res.getString(3);
            String an3 = res.getString(4);
            String an4 = res.getString(5);
            String tran = res.getString(6);

            QuestList newuser1 = new QuestList(ques, an1, an2, an3, an4, tran);
            queslist1.add(newuser1);
        }
        return queslist1;
    }

    public ArrayList<user_score_list> getAllScore() {
        ArrayList<user_score_list> scorelist = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from User_score ORDER BY score DESC",null);
        while(res.moveToNext()) {
            String user = res.getString(1);
            Integer score = res.getInt(2);
            String type = res.getString(3);

            user_score_list newuser2 = new user_score_list(user, type, score);
            scorelist.add(newuser2);
        }
        return scorelist;
    }

}
