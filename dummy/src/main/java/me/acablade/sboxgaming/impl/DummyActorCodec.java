package me.acablade.sboxgaming.impl;

import me.acablade.sboxgaming.platform.ActorCodec;

public class DummyActorCodec implements ActorCodec<DummyActor> {
    @Override
    public String serialize(DummyActor actor) {
        return actor.name();
    }

    @Override
    public DummyActor deserialize(String raw) {
        return new DummyActor(raw);
    }
}
