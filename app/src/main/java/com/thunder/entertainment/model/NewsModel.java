package com.thunder.entertainment.model;

import com.thunder.entertainment.common.base.BaseData;

import java.util.List;

/**
 * Created by beibeizhu on 17/6/14.
 */

public class NewsModel extends BaseData {

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"e65eadb5f68158857cacd44e8cd6d020","title":"十有九准，63年属兔人的后半辈子，准的难以置信！","date":"2017-06-14 12:25","category":"头条","author_name":"看守相面看久字","url":"http://mini.eastday.com/mobile/170614122514327.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170614/20170614122514_06f91d1581decfd55c7dfd72089f1f28_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170614/20170614122514_06f91d1581decfd55c7dfd72089f1f28_1_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170614/20170614122514_06f91d1581decfd55c7dfd72089f1f28_2_mwpm_03200403.jpeg"},{"uniquekey":"b0c03d1b9673a80ac112eb4315e8d8ac","title":"之前被朝鲜扣押17个月的美国大学生已乘机抵达俄亥俄","date":"2017-06-14 12:48","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/170614124840665.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170614/20170614124840_a565a8bb79c528d124c377fbff9d3a46_1_mwpm_03200403.jpeg"},{"uniquekey":"9f38106c0620ee3ef0f679b4c8522536","title":"李光耀子女发公开信与李显龙决裂 后者深感难过并否认指控","date":"2017-06-14 12:22","category":"头条","author_name":"环球时报","url":"http://mini.eastday.com/mobile/170614122231921.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170614/20170614122231_46446beb0f57951e7b5502db6d72aca2_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170614/20170614122231_46446beb0f57951e7b5502db6d72aca2_2_mwpm_03200403.png"},{"uniquekey":"0edd56179ca0deae447d59c19d5eb31e","title":"拨云见日，蛋鸡一个劲的上涨，养鸡人信心大振","date":"2017-06-14 12:22","category":"头条","author_name":"畜牧大集网","url":"http://mini.eastday.com/mobile/170614122217300.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170614/20170614122217_64c7f01da9f4fd1ceeea1b421845ff0e_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170614/20170614122217_64c7f01da9f4fd1ceeea1b421845ff0e_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170614/20170614122217_64c7f01da9f4fd1ceeea1b421845ff0e_2_mwpm_03200403.jpeg"},{"uniquekey":"4812a07b4ee9d9f15402e2b765b98414","title":"人民币收藏中的\u201c闪电币\u201d，碰到就是赚到，一张顶十张！","date":"2017-06-14 12:11","category":"头条","author_name":"藏海无边","url":"http://mini.eastday.com/mobile/170614121150735.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170614/20170612_2758b6e27bc4d9364d0cbb8c36c3bb53_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170614/20170612_9be772b88d27979997a7237597bc5e82_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170614/20170612_df505e2958ff59c005e9b8a426ed6feb_mwpm_03200403.jpg"},{"uniquekey":"f3c94b5b68fc24034f645b1acf5e1ca1","title":"晚上千万不要吃它，再喜欢也要戒口！","date":"2017-06-14 12:00","category":"头条","author_name":"食话","url":"http://mini.eastday.com/mobile/170614120050049.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170614/20170614120050_98d9acedaf497e6b1bfbe97fe132e158_2_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170614/20170614120050_98d9acedaf497e6b1bfbe97fe132e158_1_mwpm_03200403.jpeg"},{"uniquekey":"49720ed254cf4d1ccf83b8838b0a9fea","title":"刷牙的正确方法 这样刷牙等于自残，99%的人都刷错了","date":"2017-06-14 12:00","category":"头条","author_name":"健康生活课堂","url":"http://mini.eastday.com/mobile/170614120049585.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614120049_af06bca7013f2e00568c3c9b4f63d689_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170614/20170614120049_af06bca7013f2e00568c3c9b4f63d689_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170614/20170614120049_af06bca7013f2e00568c3c9b4f63d689_3_mwpm_03200403.jpeg"},{"uniquekey":"feed87361361e481c9e635db53aa3ae7","title":"蔡英文维持现状论实为追求\u201c台独\u201d？国台办回应","date":"2017-06-14 11:56","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170614115620957.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170614/20170614115620_60cacdde40e6675471715fed13f0f3fd_1_mwpm_03200403.jpeg"},{"uniquekey":"225f2b692ba8d99288ad92115d4d00b6","title":"未成年少女KTV内遭强奸 下手的竟是男友\"兄弟\"","date":"2017-06-14 11:55","category":"头条","author_name":"中华网官微","url":"http://mini.eastday.com/mobile/170614115538517.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614115538_e94a0904f6e3de30d14fab824fc2cb1e_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170614/20170614115538_e94a0904f6e3de30d14fab824fc2cb1e_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170614/20170614115538_e94a0904f6e3de30d14fab824fc2cb1e_2_mwpm_03200403.jpeg"},{"uniquekey":"7cf46df0827cde6460dd1759dd0c51a5","title":"印度将在边境部署世界第一轻坦几十万山地军：中国立即让他们曝光","date":"2017-06-14 11:48","category":"头条","author_name":"图说军事","url":"http://mini.eastday.com/mobile/170614114802710.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170614/20170614114802_d9424284eb8d3d169b1cc2f7767e4a68_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170614/20170614114802_d9424284eb8d3d169b1cc2f7767e4a68_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170614/20170614114802_d9424284eb8d3d169b1cc2f7767e4a68_1_mwpm_03200403.jpeg"},{"uniquekey":"d1fd368ecc69f095705d974c2dd8dcb4","title":"中国最强悍的男人，一夜五次郎，一天吃十斤牛肉，还活了八十多岁","date":"2017-06-14 11:39","category":"头条","author_name":"晓雨淅淅","url":"http://mini.eastday.com/mobile/170614113941177.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170614/20170614113941_7b1cf93fd578a50612a5a4364324c2a9_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170614/20170614113941_7b1cf93fd578a50612a5a4364324c2a9_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170614/20170614113941_7b1cf93fd578a50612a5a4364324c2a9_4_mwpm_03200403.jpeg"},{"uniquekey":"fb39bcf6f1796422d926d042a6709329","title":"江苏高考满分作文曝光？考试院回应","date":"2017-06-14 11:27","category":"头条","author_name":"红星新闻","url":"http://mini.eastday.com/mobile/170614112703710.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614112703_6bc9b068388146d19946d06f4677dc62_1_mwpm_03200403.jpeg"},{"uniquekey":"0cfcf84f68f178b9632bf7840ba32a55","title":"普京：俄罗斯比美国好，因为我们不监视本国公民","date":"2017-06-14 11:21","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614112132299.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170614/20170614112132_30642f272f5f7a597e53cd8d9d76ce88_1_mwpm_03200403.jpeg"},{"uniquekey":"14380838fcbd075668ca6233963f6273","title":"中科院发遥感监测绿皮书：中国耕地面积增加，优质耕地减少","date":"2017-06-14 11:20","category":"头条","author_name":"科技日报","url":"http://mini.eastday.com/mobile/170614112056338.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170614/20170614112056_820899f6118342358ebec64e215559a6_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170614/20170614112056_820899f6118342358ebec64e215559a6_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170614/20170614112056_820899f6118342358ebec64e215559a6_2_mwpm_03200403.jpeg"},{"uniquekey":"44119053f90d382d431c96ce01eee98d","title":"中国高超音速轰炸机：一小时飞到美国，现有武器无法拦截","date":"2017-06-14 11:18","category":"头条","author_name":"利刃军事","url":"http://mini.eastday.com/mobile/170614111851946.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170614/20170614_7edb8d3870a4f93a92a16f0ebfff1205_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170614/20170614_6456aed55f32d2bed4403038dfe6dfc0_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170614/20170614_d3216cfb6124dff34918b4fa9b29644d_cover_mwpm_03200403.jpeg"},{"uniquekey":"17b8178b46adb9a4f65a644a9cdfcf55","title":"江苏2017第一张高考满分作文流出？ 考试院：不可能","date":"2017-06-14 11:13","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170614111359342.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614111359_11bde6c0c37824bc0c5b792e472be9ee_1_mwpm_03200403.jpeg"},{"uniquekey":"96fe688291a43639b583c79293253dc0","title":"国台办回应\u201c台港连线\u201d：图谋和行径不得人心 不会得逞","date":"2017-06-14 11:01","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614110107356.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170614/20170614110107_1aff3cd382197f669e8c064f1319b154_1_mwpm_03200403.jpeg"},{"uniquekey":"56f39e13f74b25dd9fd3ff468e801da2","title":"日本人沉迷中国电视剧做梦都跟皇子跳舞 楚乔传海外异常火爆","date":"2017-06-14 10:56","category":"头条","author_name":"前瞻网","url":"http://mini.eastday.com/mobile/170614105620025.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614105620_315439ad032865ca3e7c1d6eb9dee717_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170614/20170614105620_304c75ec0e6250fab882d6cde7af7fd2_1_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170614/20170614105620_304c75ec0e6250fab882d6cde7af7fd2_2_mwpm_03200403.jpeg"},{"uniquekey":"b1e7f4e589b1039b92bddc5feed34df7","title":"驻华韩国文化院举行韩国文化观光周活动 纪念中韩建交25周年暨建院10周年","date":"2017-06-14 10:50","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614105058815.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170614/20170614105058_477ad4f29305baa795d5fca8fbae633e_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170614/20170614105058_477ad4f29305baa795d5fca8fbae633e_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170614/20170614105058_a670caf364cd430a5cb4ec7de89a08c7_4_mwpm_03200403.jpeg"},{"uniquekey":"62ae1dc80f4c2c7751714aac1d76be84","title":"再哭穷！美军方向国会伸手要钱 中国军事现代化再成借口","date":"2017-06-14 10:50","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614105058768.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170614/20170614105058_983bee190f947fb3896e4f9c9bfd802f_1_mwpm_03200403.jpeg"},{"uniquekey":"e044073fd6800a1b4dcebdea144b1bfd","title":"24岁乌克兰女副部长拍卖\u201c共进早餐\u201d 曾因\u201c火箭式\u201d升迁引热议","date":"2017-06-14 10:50","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614105058734.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170614/20170614105058_5bd4111e090f9449f5fd0b05b9ce9c43_1_mwpm_03200403.jpeg"},{"uniquekey":"a7c517de7f1b87f618ba136e0772b71b","title":"美民意调查显示奥巴马卸任后民众对其工作评分上升","date":"2017-06-14 10:50","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614105057012.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170614/20170614105057_3f0812ea4c95a246dfe2d79958681273_1_mwpm_03200403.jpeg"},{"uniquekey":"6bec576153d1470a0956ec88a62da8a6","title":"这个生肖人、晚年财运爆发、身价千万！","date":"2017-06-14 10:49","category":"头条","author_name":"星座星宿","url":"http://mini.eastday.com/mobile/170614104924840.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170614/20170614104924_6011074d39b0c8480c001018e758106b_1_mwpm_03200403.jpeg"},{"uniquekey":"fc6a5d29e308ec9ba26449033d38f90f","title":"西方为何不敢轻易与中国动武，因为有他，淡泊以明志，宁静以致远","date":"2017-06-14 10:48","category":"头条","author_name":"不忘他心","url":"http://mini.eastday.com/mobile/170614104845474.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170614/20170614104845_e24a523fa45440beb282c2a4e652b85a_2_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170614/20170614104845_e24a523fa45440beb282c2a4e652b85a_1_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170614/20170614104845_e24a523fa45440beb282c2a4e652b85a_3_mwpm_03200403.jpeg"},{"uniquekey":"092fa0449f73f6efa22e70b897acc3d5","title":"属马人：千万不能与这类属相过日子！不得安宁！","date":"2017-06-14 10:48","category":"头条","author_name":"五行八卦知晓","url":"http://mini.eastday.com/mobile/170614104840868.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170614/20170614104840_e574472a8168d179f0d2b92ceee4a9db_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170614/20170614104840_e574472a8168d179f0d2b92ceee4a9db_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170614/20170614104840_e574472a8168d179f0d2b92ceee4a9db_2_mwpm_03200403.png"},{"uniquekey":"ccc3e21a21fe393220a38702510538f9","title":"同济大学党委书记杨贤金调任福建省领导","date":"2017-06-14 10:47","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170614104720097.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614104720_aa7ae19c65d6273a8a6b721e51b3c807_1_mwpm_03200403.jpeg"},{"uniquekey":"d7ded041ff731f4c54c643ffd21122f5","title":"周迅和高圣远离婚 盘点周迅与8任前男友的悲欢离合","date":"2017-06-14 10:44","category":"头条","author_name":"金陵热线","url":"http://mini.eastday.com/mobile/170614104448229.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170614/20170614104448_09150c64945e54859c648f383131ff0a_2_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170614/20170614104448_1917840fd064e13ea49b37023d2f8f62_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170614/20170614104448_1917840fd064e13ea49b37023d2f8f62_4_mwpm_03200403.jpeg"},{"uniquekey":"71b609407c1105f4f7afe36c137e099c","title":"李晨为何迟迟不娶范冰冰, 无意中曝光范冰冰房间好像说明了一切","date":"2017-06-14 10:44","category":"头条","author_name":"小八说事","url":"http://mini.eastday.com/mobile/170614104434419.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170614/20170614_6433744124609c06c2204cf16c0d946a_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170614/20170614_87355c400d6c1032dd8f154467776996_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170614/20170614_8bf209feb392e00895147661458e44e1_cover_mwpm_03200403.jpeg"},{"uniquekey":"d3b67778f0d7abf4b33dc892ae250d9a","title":"南京市民称发现\u201c四脚怪兽\u201d 像壁虎还像\u201c龙\u201d","date":"2017-06-14 10:43","category":"头条","author_name":"四川新闻网","url":"http://mini.eastday.com/mobile/170614104359752.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170614/20170614104359_25a6a7a729cf933642478613893b4e39_1_mwpm_03200403.jpeg"},{"uniquekey":"7e66666ce99f968e5cb0ea2ed4936dd7","title":"一代枭雄卡扎菲被捕时说的最后一句话，让人听了心酸落泪","date":"2017-06-14 10:42","category":"头条","author_name":"亮剑精神","url":"http://mini.eastday.com/mobile/170614104222950.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170614/20170614_87537f024b3d0e073850733e3e46422c_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170614/20170614_5b4b90d027bc319f25aadbcb681f09a8_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170614/20170614_434809375848b9587e28603281e49b2f_cover_mwpm_03200403.jpeg"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    @Override
    protected String getMsg() {
        return reason;
    }

    @Override
    protected boolean getCode() {
        return error_code == 0;
    }

    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"e65eadb5f68158857cacd44e8cd6d020","title":"十有九准，63年属兔人的后半辈子，准的难以置信！","date":"2017-06-14 12:25","category":"头条","author_name":"看守相面看久字","url":"http://mini.eastday.com/mobile/170614122514327.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170614/20170614122514_06f91d1581decfd55c7dfd72089f1f28_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170614/20170614122514_06f91d1581decfd55c7dfd72089f1f28_1_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170614/20170614122514_06f91d1581decfd55c7dfd72089f1f28_2_mwpm_03200403.jpeg"},{"uniquekey":"b0c03d1b9673a80ac112eb4315e8d8ac","title":"之前被朝鲜扣押17个月的美国大学生已乘机抵达俄亥俄","date":"2017-06-14 12:48","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/170614124840665.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170614/20170614124840_a565a8bb79c528d124c377fbff9d3a46_1_mwpm_03200403.jpeg"},{"uniquekey":"9f38106c0620ee3ef0f679b4c8522536","title":"李光耀子女发公开信与李显龙决裂 后者深感难过并否认指控","date":"2017-06-14 12:22","category":"头条","author_name":"环球时报","url":"http://mini.eastday.com/mobile/170614122231921.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170614/20170614122231_46446beb0f57951e7b5502db6d72aca2_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170614/20170614122231_46446beb0f57951e7b5502db6d72aca2_2_mwpm_03200403.png"},{"uniquekey":"0edd56179ca0deae447d59c19d5eb31e","title":"拨云见日，蛋鸡一个劲的上涨，养鸡人信心大振","date":"2017-06-14 12:22","category":"头条","author_name":"畜牧大集网","url":"http://mini.eastday.com/mobile/170614122217300.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170614/20170614122217_64c7f01da9f4fd1ceeea1b421845ff0e_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170614/20170614122217_64c7f01da9f4fd1ceeea1b421845ff0e_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170614/20170614122217_64c7f01da9f4fd1ceeea1b421845ff0e_2_mwpm_03200403.jpeg"},{"uniquekey":"4812a07b4ee9d9f15402e2b765b98414","title":"人民币收藏中的\u201c闪电币\u201d，碰到就是赚到，一张顶十张！","date":"2017-06-14 12:11","category":"头条","author_name":"藏海无边","url":"http://mini.eastday.com/mobile/170614121150735.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170614/20170612_2758b6e27bc4d9364d0cbb8c36c3bb53_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170614/20170612_9be772b88d27979997a7237597bc5e82_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170614/20170612_df505e2958ff59c005e9b8a426ed6feb_mwpm_03200403.jpg"},{"uniquekey":"f3c94b5b68fc24034f645b1acf5e1ca1","title":"晚上千万不要吃它，再喜欢也要戒口！","date":"2017-06-14 12:00","category":"头条","author_name":"食话","url":"http://mini.eastday.com/mobile/170614120050049.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170614/20170614120050_98d9acedaf497e6b1bfbe97fe132e158_2_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170614/20170614120050_98d9acedaf497e6b1bfbe97fe132e158_1_mwpm_03200403.jpeg"},{"uniquekey":"49720ed254cf4d1ccf83b8838b0a9fea","title":"刷牙的正确方法 这样刷牙等于自残，99%的人都刷错了","date":"2017-06-14 12:00","category":"头条","author_name":"健康生活课堂","url":"http://mini.eastday.com/mobile/170614120049585.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614120049_af06bca7013f2e00568c3c9b4f63d689_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170614/20170614120049_af06bca7013f2e00568c3c9b4f63d689_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170614/20170614120049_af06bca7013f2e00568c3c9b4f63d689_3_mwpm_03200403.jpeg"},{"uniquekey":"feed87361361e481c9e635db53aa3ae7","title":"蔡英文维持现状论实为追求\u201c台独\u201d？国台办回应","date":"2017-06-14 11:56","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170614115620957.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170614/20170614115620_60cacdde40e6675471715fed13f0f3fd_1_mwpm_03200403.jpeg"},{"uniquekey":"225f2b692ba8d99288ad92115d4d00b6","title":"未成年少女KTV内遭强奸 下手的竟是男友\"兄弟\"","date":"2017-06-14 11:55","category":"头条","author_name":"中华网官微","url":"http://mini.eastday.com/mobile/170614115538517.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614115538_e94a0904f6e3de30d14fab824fc2cb1e_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170614/20170614115538_e94a0904f6e3de30d14fab824fc2cb1e_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170614/20170614115538_e94a0904f6e3de30d14fab824fc2cb1e_2_mwpm_03200403.jpeg"},{"uniquekey":"7cf46df0827cde6460dd1759dd0c51a5","title":"印度将在边境部署世界第一轻坦几十万山地军：中国立即让他们曝光","date":"2017-06-14 11:48","category":"头条","author_name":"图说军事","url":"http://mini.eastday.com/mobile/170614114802710.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170614/20170614114802_d9424284eb8d3d169b1cc2f7767e4a68_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170614/20170614114802_d9424284eb8d3d169b1cc2f7767e4a68_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170614/20170614114802_d9424284eb8d3d169b1cc2f7767e4a68_1_mwpm_03200403.jpeg"},{"uniquekey":"d1fd368ecc69f095705d974c2dd8dcb4","title":"中国最强悍的男人，一夜五次郎，一天吃十斤牛肉，还活了八十多岁","date":"2017-06-14 11:39","category":"头条","author_name":"晓雨淅淅","url":"http://mini.eastday.com/mobile/170614113941177.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170614/20170614113941_7b1cf93fd578a50612a5a4364324c2a9_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170614/20170614113941_7b1cf93fd578a50612a5a4364324c2a9_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170614/20170614113941_7b1cf93fd578a50612a5a4364324c2a9_4_mwpm_03200403.jpeg"},{"uniquekey":"fb39bcf6f1796422d926d042a6709329","title":"江苏高考满分作文曝光？考试院回应","date":"2017-06-14 11:27","category":"头条","author_name":"红星新闻","url":"http://mini.eastday.com/mobile/170614112703710.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614112703_6bc9b068388146d19946d06f4677dc62_1_mwpm_03200403.jpeg"},{"uniquekey":"0cfcf84f68f178b9632bf7840ba32a55","title":"普京：俄罗斯比美国好，因为我们不监视本国公民","date":"2017-06-14 11:21","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614112132299.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170614/20170614112132_30642f272f5f7a597e53cd8d9d76ce88_1_mwpm_03200403.jpeg"},{"uniquekey":"14380838fcbd075668ca6233963f6273","title":"中科院发遥感监测绿皮书：中国耕地面积增加，优质耕地减少","date":"2017-06-14 11:20","category":"头条","author_name":"科技日报","url":"http://mini.eastday.com/mobile/170614112056338.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170614/20170614112056_820899f6118342358ebec64e215559a6_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170614/20170614112056_820899f6118342358ebec64e215559a6_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170614/20170614112056_820899f6118342358ebec64e215559a6_2_mwpm_03200403.jpeg"},{"uniquekey":"44119053f90d382d431c96ce01eee98d","title":"中国高超音速轰炸机：一小时飞到美国，现有武器无法拦截","date":"2017-06-14 11:18","category":"头条","author_name":"利刃军事","url":"http://mini.eastday.com/mobile/170614111851946.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170614/20170614_7edb8d3870a4f93a92a16f0ebfff1205_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170614/20170614_6456aed55f32d2bed4403038dfe6dfc0_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170614/20170614_d3216cfb6124dff34918b4fa9b29644d_cover_mwpm_03200403.jpeg"},{"uniquekey":"17b8178b46adb9a4f65a644a9cdfcf55","title":"江苏2017第一张高考满分作文流出？ 考试院：不可能","date":"2017-06-14 11:13","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170614111359342.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614111359_11bde6c0c37824bc0c5b792e472be9ee_1_mwpm_03200403.jpeg"},{"uniquekey":"96fe688291a43639b583c79293253dc0","title":"国台办回应\u201c台港连线\u201d：图谋和行径不得人心 不会得逞","date":"2017-06-14 11:01","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614110107356.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170614/20170614110107_1aff3cd382197f669e8c064f1319b154_1_mwpm_03200403.jpeg"},{"uniquekey":"56f39e13f74b25dd9fd3ff468e801da2","title":"日本人沉迷中国电视剧做梦都跟皇子跳舞 楚乔传海外异常火爆","date":"2017-06-14 10:56","category":"头条","author_name":"前瞻网","url":"http://mini.eastday.com/mobile/170614105620025.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614105620_315439ad032865ca3e7c1d6eb9dee717_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170614/20170614105620_304c75ec0e6250fab882d6cde7af7fd2_1_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170614/20170614105620_304c75ec0e6250fab882d6cde7af7fd2_2_mwpm_03200403.jpeg"},{"uniquekey":"b1e7f4e589b1039b92bddc5feed34df7","title":"驻华韩国文化院举行韩国文化观光周活动 纪念中韩建交25周年暨建院10周年","date":"2017-06-14 10:50","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614105058815.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170614/20170614105058_477ad4f29305baa795d5fca8fbae633e_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170614/20170614105058_477ad4f29305baa795d5fca8fbae633e_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170614/20170614105058_a670caf364cd430a5cb4ec7de89a08c7_4_mwpm_03200403.jpeg"},{"uniquekey":"62ae1dc80f4c2c7751714aac1d76be84","title":"再哭穷！美军方向国会伸手要钱 中国军事现代化再成借口","date":"2017-06-14 10:50","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614105058768.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170614/20170614105058_983bee190f947fb3896e4f9c9bfd802f_1_mwpm_03200403.jpeg"},{"uniquekey":"e044073fd6800a1b4dcebdea144b1bfd","title":"24岁乌克兰女副部长拍卖\u201c共进早餐\u201d 曾因\u201c火箭式\u201d升迁引热议","date":"2017-06-14 10:50","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614105058734.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170614/20170614105058_5bd4111e090f9449f5fd0b05b9ce9c43_1_mwpm_03200403.jpeg"},{"uniquekey":"a7c517de7f1b87f618ba136e0772b71b","title":"美民意调查显示奥巴马卸任后民众对其工作评分上升","date":"2017-06-14 10:50","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170614105057012.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170614/20170614105057_3f0812ea4c95a246dfe2d79958681273_1_mwpm_03200403.jpeg"},{"uniquekey":"6bec576153d1470a0956ec88a62da8a6","title":"这个生肖人、晚年财运爆发、身价千万！","date":"2017-06-14 10:49","category":"头条","author_name":"星座星宿","url":"http://mini.eastday.com/mobile/170614104924840.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170614/20170614104924_6011074d39b0c8480c001018e758106b_1_mwpm_03200403.jpeg"},{"uniquekey":"fc6a5d29e308ec9ba26449033d38f90f","title":"西方为何不敢轻易与中国动武，因为有他，淡泊以明志，宁静以致远","date":"2017-06-14 10:48","category":"头条","author_name":"不忘他心","url":"http://mini.eastday.com/mobile/170614104845474.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170614/20170614104845_e24a523fa45440beb282c2a4e652b85a_2_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170614/20170614104845_e24a523fa45440beb282c2a4e652b85a_1_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170614/20170614104845_e24a523fa45440beb282c2a4e652b85a_3_mwpm_03200403.jpeg"},{"uniquekey":"092fa0449f73f6efa22e70b897acc3d5","title":"属马人：千万不能与这类属相过日子！不得安宁！","date":"2017-06-14 10:48","category":"头条","author_name":"五行八卦知晓","url":"http://mini.eastday.com/mobile/170614104840868.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170614/20170614104840_e574472a8168d179f0d2b92ceee4a9db_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170614/20170614104840_e574472a8168d179f0d2b92ceee4a9db_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170614/20170614104840_e574472a8168d179f0d2b92ceee4a9db_2_mwpm_03200403.png"},{"uniquekey":"ccc3e21a21fe393220a38702510538f9","title":"同济大学党委书记杨贤金调任福建省领导","date":"2017-06-14 10:47","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170614104720097.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170614/20170614104720_aa7ae19c65d6273a8a6b721e51b3c807_1_mwpm_03200403.jpeg"},{"uniquekey":"d7ded041ff731f4c54c643ffd21122f5","title":"周迅和高圣远离婚 盘点周迅与8任前男友的悲欢离合","date":"2017-06-14 10:44","category":"头条","author_name":"金陵热线","url":"http://mini.eastday.com/mobile/170614104448229.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170614/20170614104448_09150c64945e54859c648f383131ff0a_2_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170614/20170614104448_1917840fd064e13ea49b37023d2f8f62_3_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170614/20170614104448_1917840fd064e13ea49b37023d2f8f62_4_mwpm_03200403.jpeg"},{"uniquekey":"71b609407c1105f4f7afe36c137e099c","title":"李晨为何迟迟不娶范冰冰, 无意中曝光范冰冰房间好像说明了一切","date":"2017-06-14 10:44","category":"头条","author_name":"小八说事","url":"http://mini.eastday.com/mobile/170614104434419.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170614/20170614_6433744124609c06c2204cf16c0d946a_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170614/20170614_87355c400d6c1032dd8f154467776996_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170614/20170614_8bf209feb392e00895147661458e44e1_cover_mwpm_03200403.jpeg"},{"uniquekey":"d3b67778f0d7abf4b33dc892ae250d9a","title":"南京市民称发现\u201c四脚怪兽\u201d 像壁虎还像\u201c龙\u201d","date":"2017-06-14 10:43","category":"头条","author_name":"四川新闻网","url":"http://mini.eastday.com/mobile/170614104359752.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170614/20170614104359_25a6a7a729cf933642478613893b4e39_1_mwpm_03200403.jpeg"},{"uniquekey":"7e66666ce99f968e5cb0ea2ed4936dd7","title":"一代枭雄卡扎菲被捕时说的最后一句话，让人听了心酸落泪","date":"2017-06-14 10:42","category":"头条","author_name":"亮剑精神","url":"http://mini.eastday.com/mobile/170614104222950.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170614/20170614_87537f024b3d0e073850733e3e46422c_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170614/20170614_5b4b90d027bc319f25aadbcb681f09a8_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170614/20170614_434809375848b9587e28603281e49b2f_cover_mwpm_03200403.jpeg"}]
         */

        private String stat;
        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * uniquekey : e65eadb5f68158857cacd44e8cd6d020
             * title : 十有九准，63年属兔人的后半辈子，准的难以置信！
             * date : 2017-06-14 12:25
             * category : 头条
             * author_name : 看守相面看久字
             * url : http://mini.eastday.com/mobile/170614122514327.html
             * thumbnail_pic_s : http://00.imgmini.eastday.com/mobile/20170614/20170614122514_06f91d1581decfd55c7dfd72089f1f28_3_mwpm_03200403.jpeg
             * thumbnail_pic_s02 : http://00.imgmini.eastday.com/mobile/20170614/20170614122514_06f91d1581decfd55c7dfd72089f1f28_1_mwpm_03200403.jpeg
             * thumbnail_pic_s03 : http://00.imgmini.eastday.com/mobile/20170614/20170614122514_06f91d1581decfd55c7dfd72089f1f28_2_mwpm_03200403.jpeg
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }
}
