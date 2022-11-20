	<?php
	header("Content-type: application/vnd-ms-excel");
	header("Content-Disposition: attachment; filename=Gaji Karyawan.xls");
	?>
 
	<center>
		<h3>PT Surabaya Technology Information <br/> SLIP GAJI 2021</h3>
	</center>
 
	<table border="1">
		<tr>
			<th>No</th>
			<th>Nama</th>
			<th>Jabatan</th>
            <th>Gaji</th>
            <th>Tunjangan</th>
            <th>Ppn</th>
            <th>Total</th>
		</tr>
		<?php 
		// koneksi database
		$koneksi = mysqli_connect("localhost","root","","happypuppy");
 
		// menampilkan data pegawai
		$data = mysqli_query($koneksi,"select * from karyawan");
		$no = 1;
        $num = 5;
		while($d = mysqli_fetch_array($data)){
		?>
		<tr>
			<td><?php echo $no++; ?></td>
			<td><?php echo $d['nama']; ?></td>
			<td><?php echo $d['jabatan']; ?></td>
            <td><?php echo ('=IF(C'),$num,('="Direktur"; 3000000; IF( C'),$num,('="Manager"; 2000000;IF( C'),$num,('="Karyawan"; 1000000;800000)))');?></td>
            <td><?php echo ('=D'),$num,('*10%');?></td>
            <td><?php echo ('=D'),$num,('*20%');?></td>
            <td><?php echo ('=D'),$num,('+E'),$num,('-F'),$num++;?></td>
		</tr>
		<?php
		}
    
		?>
	</table>