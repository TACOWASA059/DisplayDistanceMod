# Display Distance Mod

Minecraft Forge 1.20.1 用のサーバーサイド Mod で、  
`TextDisplay` / `ItemDisplay` / `BlockDisplay` エンティティの描画距離制限を拡張・調整できます。

---

## 主な機能

- 距離は **チャンク単位**（1チャンク = 16ブロック）で指定。
- 設定値は **コマンド**で変更可能、即時反映。
- サーバー側のみで動作し、クライアント側の導入は不要。

---

## コマンド

| コマンド                    | 説明                                |
|-------------------------|-----------------------------------|
| `/ddconfig get`         | 現在の Display エンティティ描画距離（チャンク単位）を表示 |
| `/ddconfig set <value>` | 描画距離を `<value>` チャンクに設定（1〜512）    |

**例**
```
/ddconfig get
→ Display tracking range = 32 chunks

/ddconfig set 64
→ Display tracking range set to 64 chunks
```
---

## コンフィグファイル

`config/displaydistancemod-common.toml` に保存されます。

```toml
# Tracking range for Display entities (in CHUNKS).
# This controls how far the server will send TextDisplay/ItemDisplay/BlockDisplay to players.
displayTrackingRangeChunks = 32
```
