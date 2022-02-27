public class karyawan {
	private String id,nama,jenis,jabatan;
	private int gaji;
	
	public String getId(){
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNama(){
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getJenis(){
		return jenis;
	}
	
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
	public String getJabatan(){
		return jabatan;
	}
	
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	public int getGaji(){
		return gaji;
	}
	
	public void setGaji(int gaji) {
		this.gaji = gaji;
	}
	
	public karyawan(String id, String nama, String jenis, String jabatan, int gaji) {
		this.id = id;
		this.nama = nama;
		this.jenis = jenis;
		this.jabatan = jabatan;
		this.gaji = gaji;
	}
}
