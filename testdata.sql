insert Sessions (`id`, `start_time`, `end_time`, `title`, `description`, `slide_url`, `movie_url`)
value(1, 1574157622, 1574163622, 'PHPからgoへの移行で分かったこと', '弊社バックエンドは、PHPエンジニアのみで開発を行なっていました。 PHPからgoへの移行を行ったところ、トレーニング、開発環境構築、障害対応など想定外の問題が発生しました。 時代の流れとともに、goへの移行が選択肢に上がるケースが増えて来ているかと思います。 これらの知見を共有することで、goに移行した方が良いケースと悪いケースを明らかにしたいと思います。', 'https://www.slideshare.net/greetech/phpgo-200234954', 'https://www.youtube.com/watch?v=PD4lWpEXE2Q');

insert Sessions (`id`, `start_time`, `end_time`, `title`, `description`, `slide_url`, `movie_url`)
value(2, 1574157622, 1574163622, 'エンジニア以外の方が自らSQLを使ってセグメント分析を行うカルチャーをどのように作っていったか', 'リミアでは私達のチームが中心となって分析基盤を更新し、企画運営担当がSQLを使って自分が欲しい情報を分析できるようにしました。これにより、コンテンツやユーザに対する理解が深まり、KPIや業務効率の改善に繋がりました。 エンジニア以外の方が自らSQLを使ってセグメント分析を行う分析基盤やカルチャーをどのように作っていったか、またその結果どのような成果を達成できたか、そして当初の目論見と異なった点について説明します。', 'https://www.slideshare.net/greetech/sql-203319046', 'https://www.youtube.com/watch?v=qad2CqdgjzU');

insert Sessions (`id`, `start_time`, `end_time`, `title`, `description`, `slide_url`, `movie_url`)
value(3, 1574157622, 1574163622, 'あなたたちの中で罪を犯したことのない者が、まず、この広告SDK開発者に石を投げなさい。', 'iOSエンジニアという職業にはiOSアプリケーション開発をしている人間だけではなく、インターネット広告のサービスを利用するためのSDKを開発している人間も含まれております。 このセッションでは、モバイル向け広告SDKを開発/運用しているエンジニアの考えていることや、開発する上で大事にしていること、課題に感じていること、開発の方法などを発表します。', 'https://www.slideshare.net/greetech/realityvtuber1', 'https://www.youtube.com/watch?v=A0Ro_f5kzc8');

insert Speakers (`id`, `name`, `title`, `github_id`, `twitter_id`, `description`)
value(1, "Haruki Nakano", "Android Engineer", "haru067", "haru067", "最近はフィットネスと一体化しつつあります。");
insert Speakers (`id`, `name`, `title`, `github_id`, `twitter_id`, `description`)
value(2, "Takayuki Sei", "iOS Engineer", "", "tion-low", "");
insert Speakers (`id`, `name`, `title`, `github_id`, `twitter_id`, `description`)
value(3, "Masahiro Higuchi", "Backend Engineer", "aaaa", "", "少し長めの文章をここに試しに入力あいうえおかきくけこさしすせそくぁｗせｄｒｆｔｇｙふじこｌｐ；");

insert SpeakerRelations (`session_id`, `speaker_id`) value(1,1);
insert SpeakerRelations (`session_id`, `speaker_id`) value(2,2);
insert SpeakerRelations (`session_id`, `speaker_id`) value(3,3);

insert Tags (`id`, `name`) value(1, 'iOS');
insert Tags (`id`, `name`) value(2, 'Android');
insert Tags (`id`, `name`) value(3, 'Web');
insert Tags (`id`, `name`) value(4, 'PHP');
insert Tags (`id`, `name`) value(5, 'go');
insert Tags (`id`, `name`) value(6, 'Kotlin');
insert Tags (`id`, `name`) value(7, 'Swift');

insert TagRelations (`session_id`, `tag_id`) value(1,3);
insert TagRelations (`session_id`, `tag_id`) value(1,4);
insert TagRelations (`session_id`, `tag_id`) value(1,5);
insert TagRelations (`session_id`, `tag_id`) value(2,3);
insert TagRelations (`session_id`, `tag_id`) value(3,1);
insert TagRelations (`session_id`, `tag_id`) value(3,7);

