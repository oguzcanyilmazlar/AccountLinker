package me.acablade.sboxgaming.platform;

public interface ActorCodec<T extends AccountLinkingActor> {

    String serialize(T actor);
    T deserialize(String raw);

}
