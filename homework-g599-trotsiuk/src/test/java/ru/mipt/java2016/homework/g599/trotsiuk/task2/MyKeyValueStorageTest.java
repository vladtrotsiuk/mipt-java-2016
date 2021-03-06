package ru.mipt.java2016.homework.g599.trotsiuk.task2;

import ru.mipt.java2016.homework.base.task2.KeyValueStorage;
import ru.mipt.java2016.homework.tests.task2.AbstractSingleFileStorageTest;
import ru.mipt.java2016.homework.tests.task2.Student;
import ru.mipt.java2016.homework.tests.task2.StudentKey;

import java.io.IOException;

public class MyKeyValueStorageTest extends AbstractSingleFileStorageTest {

    @Override
    protected KeyValueStorage<String, String> buildStringsStorage(String path) {
        DataBase<String, String> db;
        try {
            db = new DataBase(path,
                    new SerializerString(),
                    new SerializerString());
        }catch (IOException exp) {
            return null;
        }
        return db;
    }

    @Override
    protected KeyValueStorage<Integer, Double> buildNumbersStorage(String path) {
        DataBase<Integer, Double> db;
        try {
            db = new DataBase(path,
                    new SerializerInteger(),
                    new SerializerDouble());
        } catch (IOException exp) {
            return null;
        }
        return db;
    }

    @Override
    protected KeyValueStorage<StudentKey, Student> buildPojoStorage(String path) {
        DataBase<StudentKey, Student> db;
        try {
            db = new DataBase(path,
                    new SerializerStudentKey(),
                    new SerializerStudent());
        } catch (IOException exp) {
            return null;
        }
        return db;
    }
}