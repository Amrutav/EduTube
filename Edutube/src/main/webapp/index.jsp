<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>

    <!-- Include the FontAwesome CSS if you want to use feedback icons provided by FontAwesome -->
    <!--<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" />-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="dist/css/formValidation.css"/>
    <link rel="stylesheet" href="css/style.css">

    <script type="text/javascript" src="vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="dist/js/formValidation.js"></script>
    <script type="text/javascript" src="dist/js/framework/bootstrap.js"></script>
	<script type="text/javascript" src="vendor/jquery/jquery.msgbox.js"></script>
	<script type="text/javascript" src="vendor/jquery/jquery.msgbox.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.msgbox.css" />
</head>
<body>

<div class="container">
   <div class="form">
<a href="http://www.facebook.com/dialog/oauth/?client_id=490694001088434&redirect_uri=http://localhost:8080/FwdSample/user/facebookLogin?scope=email,public_profile"><img src="img/Facebook.png" style="max-width:183px; margin-bottom:20px"></a>
      <a href="<%=request.getContextPath()%>/Login.jsp">Login</a>
        <h2>Baru disini?</h2>
        <div class="tab">
           <button type="button" class="btn btn-warning btn-lg">Masuk</button>
           <p>atau</p>
           <h3>Silakan isi detail kamu di sini</h3>
        </div>
        
        <div class="clearfix"> </div>
        <hr>
        
        <div class="row">		
		   <div class="col-md-7">
			  <h3>Info detail tentang kamu</h3>

                <form id="defaultForm" method="put" class="form-horizontal">
                    <div class="form-group">
                      <label for="inputEmail" class="col-lg-4 control-label">Gender</label>
                      <div class="col-lg-8">
                        <div class="radio">
                          <label>
                            <input type="radio" name="gender" id="gender1" value="F" >
                            Female
                          </label>
                        </div>
                        <div class="radio">
                          <label>
                            <input type="radio" name="gender" id="gender2" value="G" >
                            Male
                          </label>
                        </div>
                       </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="firstname" class="col-lg-4 control-label">Nama depan</label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="firstname" name="firstName" placeholder="Nama depan" >
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="lastname" class="col-lg-4 control-label">Nama belakang</label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="lastname" name="lastName" placeholder="Nama belakang" >
                      </div>
                    </div>
                
                    <div class="form-group">
                      <label for="Email" class="col-lg-4 control-label">Email</label>
                      <div class="col-lg-8">
                        <input type="email" class="form-control" id="Email" placeholder="Email" name="email"  >
                      </div>
                    </div>

                    <div class="form-group">
                      <label for="Mobile" class="col-lg-4 control-label">Nomor handphone</label>
                      <div class="col-lg-8">
                        <input type="tel" class="form-control" id="Mobile" name="mobile" placeholder="123456789" pattern="[0-9]{10}">
                      </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="dtp_input2" class="col-lg-4 control-label">Tangal lahir</label>
                        <div class="input-group date form_date col-lg-8" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                            <input class="form-control" size="10" id="dateInput" type="text" value="" placeholder="dd/MM/yyyy" readonly>
                            
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                        <input type="hidden" id="dtp_input2" value="" /><br/>
                    </div>

                    <div class="form-group">
                  <label for="select" class="col-lg-4 control-label">Jenis identitas</label>
                  <div class="col-lg-8">
                    <select class="form-control" id="idType">
                      <option>KTP</option>
                      <option>SIM</option>
                    </select>
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="IDnumber" class="col-lg-4 control-label">Nomor identitas</label>
                  <div class="col-lg-8">
                    <input type="text" class="form-control" id="IDnumber" placeholder="123456789" pattern="[0-9]{10}">
                    <span class="help-block">Mohon membawa identitas diri (kTP/SIM)saat melakukan proses klaim</span>
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="address" class="col-lg-4 control-label">Alamat sesuai identitas</label>
                  <div class="col-lg-8">
                    <textarea class="form-control" rows="3" id="address" name="address" placeholder="Alamat sesuai identitas" ></textarea>
                    
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="address2" class="col-lg-4 control-label">Alamat surat-menyurat</label>
                  <div class="col-lg-8">
                    <span class="help-block"><input type="checkbox" id="checkbox" onchange="CopyAdd();"> Klik di sini jika sama dengan alamat sesuai identitas</span>
                     <textarea class="form-control" rows="3" id="address2" placeholder="Alamat surat-menyurat" ></textarea>
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="select" class="col-lg-4 control-label">Details penerima manfaat</label>
                  <div class="col-lg-8">
                    <select class="form-control" id="select">
                      <option>Ahl iWaris</option>
                      <option>----</option>
                    </select>
                  </div>
                </div>
                
                
                
                
                <div class="form-group">
                  <div class="col-lg-10 ">
                    <button type="reset" class="btn btn-default btn-lg">Kembali</button>
                    <button type="button" id="signup" name="signup" value="Sign up" class="btn btn-warning btn-lg">Kirim</button>
                  </div>
                </div>
                    
                </form>
                
                </div>
                
                <div class="col-md-5 note">
                <img src="img/profile.png">
				<h3>Penting untuk diketahui</h3>
				<p>
					Untuk mengajukan  permohonan Asurnsi,kamu harus tercatat sebagai:
				</p>
				<ul>
                  <li>Warga negara Indonesia</li>
                  <li>Berumur 18 sampai 65 tahun</li>
                  <li>Memiliki KTP/SIM yang masih berlaku</li>
                </ul>
				
				
</div>
                
                
            </div>
        </div>
    </div>


<script type="text/javascript" src="dist/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="dist/js/Utilsjsp.js" charset="UTF-8"></script>


</body>
</html>
