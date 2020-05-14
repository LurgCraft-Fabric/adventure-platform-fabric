/*
 * Copyright © 2020 zml [at] stellardrift [.] ca
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the “Software”), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package ca.stellardrift.text.fabric.mixin.api;

import net.kyori.adventure.key.Key;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Key.class)
@SuppressWarnings({"ConstantConditions", "mixin"})
public interface MixinKey {
    @Inject(method = "of(Ljava/lang/String;)Lnet/kyori/adventure/key/Key;", at = @At("HEAD"), cancellable = true, remap = false)
    static void create(String value, CallbackInfoReturnable<Key> cir) {
        cir.setReturnValue((Key) (Object) new Identifier(value));
    }

    @Inject(method = "of(Ljava/lang/String;C)Lnet/kyori/adventure/key/Key;", at = @At("HEAD"), cancellable = true, remap = false)
    static void create(String value, char delimiter, CallbackInfoReturnable<Key> cir) {
        cir.setReturnValue((Key) (Object) Identifier.splitOn(value, delimiter));
    }

    @Inject(method = "of(Ljava/lang/String;Ljava/lang/String;)Lnet/kyori/adventure/key/Key;", at = @At("HEAD"), cancellable = true, remap = false)
    static void create(String namespace, String value, CallbackInfoReturnable<Key> cir) {
        cir.setReturnValue((Key) (Object) new Identifier(namespace, value));
    }


}
