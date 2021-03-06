/*
 * A program to automatically trade cryptocurrencies.
 * Copyright (C) 2020 Tomas Skalicky
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.skalicky.cryptobot.exchange.kraken.connector.api.dto;

import javax.annotation.Nullable;
import java.util.List;

public class KrakenResponseDto<Result> {
    @Nullable
    private List<String> error;
    @Nullable
    private Result result;

    @Nullable
    public List<String> getError() {
        return error;
    }

    public void setError(@Nullable final List<String> error) {
        this.error = error;
    }

    @Nullable
    public Result getResult() {
        return result;
    }

    public void setResult(@Nullable final Result result) {
        this.result = result;
    }
}
