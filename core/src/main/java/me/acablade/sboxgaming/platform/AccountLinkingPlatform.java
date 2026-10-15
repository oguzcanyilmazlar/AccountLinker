package me.acablade.sboxgaming.platform;

import me.acablade.sboxgaming.provider.AccountLinking;

import java.util.Map;
import java.util.Optional;

public record AccountLinkingPlatform<T extends AccountLinkingActor>(ActorCodec<T> codec, Map<String, AccountLinking<T>> providers) {

    public static <K extends AccountLinkingActor> PlatformBuilder<K> builder(ActorCodec<K> codec){
        return new PlatformBuilder<>(codec);
    }

    public AccountLinkingPlatform {
        providers = Map.copyOf(providers);
    }

    public Optional<AccountLinking<T>> provider(String id){
        return Optional.ofNullable(providers.get(id));
    }

}