package genandnic.walljump.client;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.minecraft.sounds.SoundEvents.ELYTRA_FLYING;
import static net.minecraft.sounds.SoundSource.PLAYERS;

@OnlyIn(Dist.CLIENT)
public class FallingSound extends AbstractTickableSoundInstance {
    private final AbstractClientPlayer player;

    public FallingSound(AbstractClientPlayer player) {
        super(ELYTRA_FLYING, PLAYERS, RandomSource.create());
        this.player = player;
        this.looping = true;
        this.delay = 0;
        this.volume = Float.MIN_VALUE;

    }

    public void tick() {

        float length = (float) player.getDeltaMovement().lengthSqr();
        if (length >= 1.0 && player.isAlive()) {

            volume = Mth.clamp((length - 1.0F) / 4.0F, 0.0F, 2.0F);

            if (volume > 0.8F) {
                pitch = 1.0F + (volume - 0.8F);
            } else {
                pitch = 1.0F;
            }

        } else {

            this.stop();

        }

    }


}