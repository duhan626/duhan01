
package com.shujuniu.cache.config;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;


/**
 * Kyro序列化工具
 */
public class KryoSerializer {

    public static byte[] serialize(Object t) {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.register(t.getClass(), new JavaSerializer());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        kryo.writeClassAndObject(output, t);
        output.flush();
        output.close();
        return baos.toByteArray();
    }

    public static <T extends Serializable> T deserialize(byte[] bytes, Class<T> clazz) {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.register(clazz, new JavaSerializer());
        Input input = new Input(bytes);
        T t = (T) kryo.readClassAndObject(input);
        return t;
    }
}
