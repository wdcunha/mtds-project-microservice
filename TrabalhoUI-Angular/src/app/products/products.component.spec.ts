import { TestBed, async } from '@angular/core/testing';
import { ProductsComponent } from './products.component';

describe('ProductsComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        ProductsComponent
      ],
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(ProductsComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'apiconsumingangular8'`, () => {
    const fixture = TestBed.createComponent(ProductsComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('apiconsumingangular8');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(ProductsComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('.content span').textContent).toContain('apiconsumingangular8 app is running!');
  });
});
