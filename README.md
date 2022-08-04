# 概要
シンプルな「Spring Data JPA」のサンプルで、以下の機能を実装しています。
- データの追加、編集、削除
- データの取得(多対１、１対多)

# テーブル構成
## 会員種別テーブル(member_types)
| カラム | 内容 | 備考 |
|---|---|---|
| id | 会員種別ID | 主キー
| name | 会員種別名 | |

## 会員テーブル(members)
| カラム | 内容 | 備考 |
|---|---|---|
| id | 会員ID | 主キー
| name | 氏名 | |
| age | 年齢 | |
| address | 住所 | |
| type_id | 会員種別ID | 会員種別テーブルと連携 |
| created | 登録日時 | |

# ページ構成
| URL | 内容 | 備考 |
|---|---|---|
| /list | 会員リストの表示 | 多対１の連携 |
| /list/{typeId} | 会員種別で絞り込み | １対多の連携 |
| /show/{id} | IDに基づく会員情報の個別表示 | |
| /save | 会員情報の登録・編集 | |
| /delete| 会員情報の削除 | |

# 主要ファイル
## src/main/resources
| ディレクトリ | ファイル名 | 内容 |
|---|---|---|
|  | setupdata.sql | テーブルの作成、初期データ投入用のSQLファイル |
| templates | list.html | 会員リスト表示用HTML |
| templates | listByType.html | 絞り込み表示用HTML |
| templates | show.html | 個別表示用HTML |
| templates | save.html | 登録・追加ページ用HTML |

## src/main/java/com/example/demo
| パッケージ | ファイル名 | 内容 |
|---|---|---|
| controller | MemberController.java | 会員の表示、追加・編集・削除を行うためのコントローラー |
| domain | MemberType.java | 会員種別の情報を保持するためのクラス |
| domain | Member.java | 会員の氏名、年齢、住所等を保持するためのクラス |
| repository | MemberTypeRepository.java | 会員種別の情報を操作するためのインターフェース |
| repository | MemberRepository.java | 会員の情報を操作するためのインターフェース |
